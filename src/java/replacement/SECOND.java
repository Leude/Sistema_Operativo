package replacement;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;

public class SECOND {

    private final StringBuilder stringBuilder = new StringBuilder();
    private int frames, pointer = 0, hit = 0, fault = 0, ref_len;

    public void execute() {
        int[] reference = new int[ref_len];
        int[][] mem_layout = new int[ref_len][frames];
        int[][] used_layout = new int[ref_len][frames];
        int[][] buffer = new int[frames][2];
        for (int j = 0; j < frames; j++) {
            buffer[j][0] = -1;
            buffer[j][1] = 0;
        }
        for (int i = 0; i < ref_len; i++) {
            reference[i] = parseInt(showInputDialog("Please enter the reference string: "));
        }
        for (int i = 0; i < ref_len; i++) {
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j][0] == reference[i]) {
                    search = j;
                    hit++;
                    buffer[j][1] = 1;
                    break;
                }
            }
            if (search == -1) {

                while (buffer[pointer][1] == 1) {
                    buffer[pointer][1] = 0;
                    pointer++;
                    if (pointer == frames)
                        pointer = 0;
                }
                buffer[pointer][0] = reference[i];
                buffer[pointer][1] = 1;
                fault++;
                pointer++;
                if (pointer == frames)
                    pointer = 0;
            }
            for (int j = 0; j < frames; j++) {
                mem_layout[i][j] = buffer[j][0];
                used_layout[i][j] = buffer[j][1];
            }
        }

        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++)
                stringBuilder.append(format("%3d %d ", mem_layout[j][i], used_layout[j][i]));
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
