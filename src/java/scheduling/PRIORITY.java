package scheduling;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;

public class PRIORITY {
    private final StringBuilder outString = new StringBuilder();

    public PRIORITY() {
        int n = parseInt(showInputDialog("Please enter the number of Processes: "));
        int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
        for (int i = 1; i <= n; i++) {
            proc[i][0] = parseInt(showInputDialog("Please enter the Arrival Time for Process " + i + ": "));
            ;
            proc[i][1] = parseInt(showInputDialog("Please enter the Burst Time for Process " + i + ": "));
        }

        //Calculation of Total Time and Initialization of Time Chart array
        int total_time = 0;
        for (int i = 1; i <= n; i++) {
            total_time += proc[i][1];
        }
        int time_chart[] = new int[total_time];

        for (int i = 0; i < total_time; i++) {
            //Selection of shortest process which has arrived
            int sel_proc = 0;
            int min = 99999;
            for (int j = 1; j <= n; j++) {
                if (proc[j][0] <= i)//Condition to check if Process has arrived
                {
                    if (proc[j][1] < min && proc[j][1] != 0) {
                        min = proc[j][1];
                        sel_proc = j;
                    }
                }
            }

            //Assign selected process to current time in the Chart
            time_chart[i] = sel_proc;

            //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
            proc[sel_proc][1]--;

            //WT and TT Calculation
            for (int j = 1; j <= n; j++) {
                if (proc[j][0] <= i) {
                    if (proc[j][1] != 0) {
                        proc[j][3]++;//If process has arrived and it has not already completed execution its TT is incremented by 1
                        if (j != sel_proc)//If the process has not been currently assigned the CPU and has arrived its WT is incremented by 1
                            proc[j][2]++;
                    } else if (j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
                        proc[j][3]++;
                }
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

        }

        outString.append("\n\n");

        //Printing the WT and TT for each Process
        outString.append("P\t WT \t TT \n");
        for (int i = 1; i <= n; i++) {
            outString.append(format("%d\t%2dms\t%2dms\n", i, proc[i][2], proc[i][3]));
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

