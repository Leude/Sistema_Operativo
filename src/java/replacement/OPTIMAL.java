package replacement;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;

public class OPTIMAL {
    private final StringBuilder stringBuilder = new StringBuilder();
    private int frames, pointer = 0, hit = 0, fault = 0, ref_len;
    private boolean isFull = false;

    public void execute() {
        int[] reference = new int[ref_len];
        int[][] mem_layout = new int[ref_len][frames];
        int[] buffer = new int[frames];
        for (int j = 0; j < frames; j++)
            buffer[j] = -1;

        for (int i = 0; i < ref_len; i++) {
            reference[i] = parseInt(showInputDialog("Ingresa"));
        }
        for (int i = 0; i < ref_len; i++) {
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == reference[i]) {
                    search = j;
                    hit++;
                    break;
                }
            }
            if (search == -1) {
                if (isFull) {
                    int index[] = new int[frames];
                    boolean index_flag[] = new boolean[frames];
                    for (int j = i + 1; j < ref_len; j++) {
                        for (int k = 0; k < frames; k++) {
                            if ((reference[j] == buffer[k]) && (index_flag[k] == false)) {
                                index[k] = j;
                                index_flag[k] = true;
                                break;
                            }
                        }
                    }
                    int max = index[0];
                    pointer = 0;
                    if (max == 0)
                        max = 200;
                    for (int j = 0; j < frames; j++) {
                        if (index[j] == 0)
                            index[j] = 200;
                        if (index[j] > max) {
                            max = index[j];
                            pointer = j;
                        }
                    }
                }
                buffer[pointer] = reference[i];
                fault++;
                if (!isFull) {
                    pointer++;
                    if (pointer == frames) {
                        pointer = 0;
                        isFull = true;
                    }
                }
            }
            for (int j = 0; j < frames; j++)
                mem_layout[i][j] = buffer[j];
        }

        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++)
                stringBuilder.append(format("%3d ", mem_layout[j][i]));
            stringBuilder.append("\n");
        }
    }

    public int getHit() {
        return hit;
    }

    public float getHitRatio() {
        return ((float) hit / ref_len);
    }

    public int getFault() {
        return fault;
    }

    public String getOutString() {
        return stringBuilder.toString();
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public void setRef_len(int ref_len) {
        this.ref_len = ref_len;
    }
}
