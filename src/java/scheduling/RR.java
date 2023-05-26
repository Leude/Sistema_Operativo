package scheduling;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;

public class RR {
    private final StringBuilder outString = new StringBuilder();

    public RR() {
        int q = parseInt(showInputDialog("Enter the Time Quantum: "));
        int n = parseInt(showInputDialog("Please enter the number of Processes: "));
        int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
        for (int i = 1; i <= n; i++) {
            proc[i][1] = parseInt(showInputDialog("Please enter the Burst Time for Process " + i + ": "));
        }

        //Calculation of Total Time and Initialization of Time Chart array
        int total_time = 0;
        for (int i = 1; i <= n; i++) {
            total_time += proc[i][1];
        }
        int time_chart[] = new int[total_time];

        int sel_proc = 1;
        int current_q = 0;
        for (int i = 0; i < total_time; i++) {
            //Assign selected process to current time in the Chart
            time_chart[i] = sel_proc;

            //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
            proc[sel_proc][1]--;

            //WT and TT Calculation
            for (int j = 1; j <= n; j++) {
                if (proc[j][1] != 0) {
                    proc[j][3]++;//If process has not completed execution its TT is incremented by 1
                    if (j != sel_proc)//If the process has not been currently assigned the CPU its WT is incremented by 1
                        proc[j][2]++;
                } else if (j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
                    proc[j][3]++;
            }

            //Printing the Time Chart
            if (i != 0) {
                if (sel_proc != time_chart[i - 1])
                //If the CPU has been assigned to a different Process we need to print the current value of time and the name of
                //the new Process
                {
                    outString.append("--" + i + "--P" + sel_proc);
                }
            } else//If the current time is 0 i.e the printing has just started we need to print the name of the First selected Process
                outString.append(i + "--P" + sel_proc);
            if (i == total_time - 1)//All the process names have been printed now we have to print the time at which execution ends
                outString.append("--" + (i + 1));

            //Updating value of sel_proc for next iteration
            current_q++;
            if (current_q == q || proc[sel_proc][1] == 0)//If Time slice has expired or the current process has completed execution
            {
                current_q = 0;
                //This will select the next valid value for sel_proc
                for (int j = 1; j <= n; j++) {
                    sel_proc++;
                    if (sel_proc == (n + 1))
                        sel_proc = 1;
                    if (proc[sel_proc][1] != 0)
                        break;
                }
            }
        }
        outString.append("\n\n");

        //Printing the WT and TT for each Process
        outString.append("P\t WT  \t TT  \n");
        for (int i = 1; i <= n; i++) {
            outString.append(format("%d\t%3dms\t%3dms", i, proc[i][2], proc[i][3]));
            outString.append("\n");
        }

        outString.append("\n");

        //Printing the average WT & TT
        float WT = 0, TT = 0;
        for (int i = 1; i <= n; i++) {
            WT += proc[i][2];
            TT += proc[i][3];
        }
        WT /= n;
        TT /= n;
        outString.append("The Average WT is: " + WT + "ms\n");
        outString.append("The Average TT is: " + TT + "ms\n");
    }

    public String getOutString() {
        return outString.toString();
    }

}
