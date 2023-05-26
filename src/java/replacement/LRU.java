package replacement;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;

public class LRU {

    private final StringBuilder stringBuilder = new StringBuilder();
    private int frames, pointer = 0, hit = 0, fault = 0, ref_len;
    private Boolean isFull = false;
    private final ArrayList<Integer> stack = new ArrayList<Integer>();

    public void execute() {
        int[] reference = new int[ref_len];
        int[][] mem_layout = new int[ref_len][frames];
        int[] buffer = new int[frames];
        for (int j = 0; j < frames; j++)
            buffer[j] = -1;

        for (int i = 0; i < ref_len; i++) {
            reference[i] = parseInt(showInputDialog("Please enter the reference string: "));
        }
        for (int i = 0; i < ref_len; i++) {
            if (stack.contains(reference[i])) {
                stack.remove(stack.indexOf(reference[i]));
            }
            stack.add(reference[i]);
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
                    int min_loc = ref_len;
                    for (int j = 0; j < frames; j++) {
                        if (stack.contains(buffer[j])) {
                            int temp = stack.indexOf(buffer[j]);
                            if (temp < min_loc) {
                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }
                buffer[pointer] = reference[i];
                fault++;
                pointer++;
                if (pointer == frames) {
                    pointer = 0;
                    isFull = true;
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
