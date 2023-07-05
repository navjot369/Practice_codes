#include <stdio.h>
int main(){
    int i, j,n, bt[50], wt[50], tat[50], at[50], temp[50];
    float awt=0, atat=0;
    printf("Enter the no. of processes: \n");
    scanf ("%d" , &n);
    printf("Enter the burst time of the processes: \n");
    for (i=0;i<n;i++){
        scanf("%d",&bt[i]);
    }
    printf("Enter the arrival time of the processe: \n");
    for (i=0;i<n;i++){
    scanf ("%d", &at[i]);
    } 
    temp[0]=0;
    printf("Process\t burst time\t arrival time\t waiting time\t turn around time \n");
    for (i=0;i<n;i++){
    wt[i]=0; 
    tat[i]=0;
    temp[i+1]=temp[i]+bt[i]; 
    wt[i]=temp[i]-at[i]; 
    tat[i]=wt[i]+bt[i]; 
    awt=awt+wt[i]; 
    atat=atat+tat[i];
    printf("%d\t%d\t\t%d\t\t%d\t\t%d\n",i+1,bt[i],at[i],wt[i],tat[i]);
    } 
    atat=atat/n; 
    awt=awt/n;
    printf("The Average Waiting Time is: %f\n", awt);
    printf("The Average Turn Around Time is: %f", atat); 
    return 0;
}