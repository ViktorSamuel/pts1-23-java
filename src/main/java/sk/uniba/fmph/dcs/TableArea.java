package sk.uniba.fmph.dcs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableArea {
    private ArrayList<TyleSource> tyleSources;

    public TableArea(ArrayList<TyleSource> tyleSources) {
        this.tyleSource = tyleSources;
    }
    public Collection<Tile> take(int sourceIdx, int idx) {
        if (sourceIdx >= 0 && sourceIdx < tyleSources.size()) {
            TyleSource selectedSource = tyleSources.get(sourceIdx);
            return selectedSource.take(idx);
        } else {
            // vrati prazdny list (namiesto exception alebo null)
            return Collections.emptyList();
        }
    }

    public boolean isRoundEnd() {
        for (TyleSource tyleSource : tyleSources) {
            if (!tyleSource.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void startNewRound() {
        for (TyleSource tyleSource : tyleSources) {
            tyleSource.startNewRound();
        }
    }

    public String state() {
        StringBuilder stateBuilder = new StringBuilder();
        for (TyleSource tyleSource : tyleSources) {
            stateBuilder.append(tyleSource.state());
            stateBuilder.append("\n");
        }
        return stateBuilder.toString();
    }
}
