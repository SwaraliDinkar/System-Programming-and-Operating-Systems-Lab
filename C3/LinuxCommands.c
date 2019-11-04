#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>


int main(int argc, char* argv[]){
	if(argc==1){
		printf("ERROR! Invalid Argument Count\n");
		return 0;
	}
	if(strcmp(argv[1], "ps")==0){
		char *ps[] = {"ps", NULL};
		execvp(ps[0], ps);
	}
	else if(strcmp(argv[1],"join")==0){
		char *join[] = {"join", argv[2], argv[3], NULL};
		execvp(join[0], join);
	}

	else if(strcmp(argv[1], "exec")==0){
		char *commands[]={"ls",NULL};
		execvp(commands[0], commands);
	}
	else if(strcmp(argv[1], "fork")==0){
		printf("PID Of Parent Process Is: : %d\n", getpid());
		pid_t pid = fork();
		if(pid==0){
			printf("PID Of Child Forked Process: : %d\n", getpid());

			return 0;
		}
		printf("PID Of Process At End: : %d\n", getpid());
	}

	else if(strcmp(argv[1], "wait")==0){
		pid_t cpid; 
	   	if (fork()== 0)
			{ 
			 exit(0);
			}	           /* terminate child */
	    	else
		{
		 cpid = wait(NULL); /* reaping parent */
		}
	    	printf("Parent pid = %d\n", getpid()); 
	    	printf("Child pid = %d\n", cpid); 
	  
    return 0; 
	}
	

	return 0;
}
