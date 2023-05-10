package algos;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class SECOND {


    int frames, pointer = 0, hit = 0, fault = 0,ref_len;
    int buffer[][];
    int reference[];
    int mem_layout[][];
    int used_layout[][];

    public void num_frames(int i) {System.out.println("Please enter the number of Frames: ");
        frames=i;

    }
    public void cantidadReferencias(int i) {
        System.out.println("Please enter the length of the Reference string: ");
        ref_len = i;
    }
    public void proceso(){
        reference = new int[ref_len];
        mem_layout = new int[ref_len][frames];
        used_layout = new int[ref_len][frames];
        buffer = new int[frames][2];
            for(int j = 0; j < frames; j++)
        {
            buffer[j][0] = -1;
            buffer[j][1] = 0;
        }
            System.out.println("Please enter the reference string: ");
            for(int i = 0; i < ref_len; i++)
        {
            reference[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa"));
        }
            System.out.println();
            for(int i = 0; i < ref_len; i++)
        {
            int search = -1;
            for(int j = 0; j < frames; j++)
            {
                if(buffer[j][0] == reference[i])
                {
                    search = j;
                    hit++;
                    buffer[j][1] = 1;
                    break;
                }
            }
            if(search == -1)
            {

                while(buffer[pointer][1] == 1)
                {
                    buffer[pointer][1] = 0;
                    pointer++;
                    if(pointer == frames)
                        pointer = 0;
                }
                buffer[pointer][0] = reference[i];
                buffer[pointer][1] = 1;
                fault++;
                pointer++;
                if(pointer == frames)
                    pointer = 0;
            }
            for(int j = 0; j < frames; j++)
            {
                mem_layout[i][j] = buffer[j][0];
                used_layout[i][j] = buffer[j][1];
            }
        }

            for(int i = 0; i < frames; i++)
        {
            for(int j = 0; j < ref_len; j++)
                System.out.printf("%3d %d ",mem_layout[j][i],used_layout[j][i]);
            System.out.println();
        }

            System.out.println("The number of Hits: " + hit);
            System.out.println("Hit Ratio: " + (float)((float)hit/ref_len));
            System.out.println("The number of Faults: " + fault);
    }
    public int getHit() {
        return hit;
    }

    public float getHitRatio() {
        return ((float) hit / ref_len);
    }

    public int getFault(){
        return fault;
    }

    public int[][] getMem_layout() {
        return mem_layout;
    }

    public int getFrames() {
        return frames;
    }

    public int getRef_len() {
        return ref_len;
    }

    public String getResultado(){
        String s = "";
        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++)
                s+="\t"+ mem_layout[j][i];

            s+="\n";
        }
        return s;
    }
}
