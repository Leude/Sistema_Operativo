package algos;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class LRU {

    int frames,pointer = 0, hit = 0, fault = 0,ref_len;
    Boolean isFull = false;
    int buffer[];
    ArrayList<Integer> stack = new ArrayList<Integer>();
    int reference[];
    int mem_layout[][];

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
        buffer = new int[frames];
        for(int j = 0; j < frames; j++)
            buffer[j] = -1;

        System.out.println("Please enter the reference string: ");
        for(int i = 0; i < ref_len; i++)
        {
            reference[i] =  Integer.parseInt(JOptionPane.showInputDialog("Ingresa"));
        }
        System.out.println();
        for(int i = 0; i < ref_len; i++)
        {
            if(stack.contains(reference[i]))
            {
                stack.remove(stack.indexOf(reference[i]));
            }
            stack.add(reference[i]);
            int search = -1;
            for(int j = 0; j < frames; j++)
            {
                if(buffer[j] == reference[i])
                {
                    search = j;
                    hit++;
                    break;
                }
            }
            if(search == -1)
            {
                if(isFull)
                {
                    int min_loc = ref_len;
                    for(int j = 0; j < frames; j++)
                    {
                        if(stack.contains(buffer[j]))
                        {
                            int temp = stack.indexOf(buffer[j]);
                            if(temp < min_loc)
                            {
                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }
                buffer[pointer] = reference[i];
                fault++;
                pointer++;
                if(pointer == frames)
                {
                    pointer = 0;
                    isFull = true;
                }
            }
            for(int j = 0; j < frames; j++)
                mem_layout[i][j] = buffer[j];
        }

        for(int i = 0; i < frames; i++)
        {
            for(int j = 0; j < ref_len; j++)
                System.out.printf("%3d ",mem_layout[j][i]);
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
