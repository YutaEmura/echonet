#include <stdlib.h>
#include <stdio.h>
#include <err.h>
#define BUF 256

int main (int argc, char *argv[]){
	FILE *fp;
	char buf[BUF];
	char *cmdline = "java -classpath .:/home/kpj/OpenECHO-master/src/core.jar:/home/kpj/OpenECHO-master/src/ecj.jar get_ac";
	if((fp=popen(cmdline, "r")) == NULL) {
		err(EXIT_FAILURE, "%s", cmdline);
	}
	while(fgets(buf, BUF, fp) != NULL) {
		(void) fputs(buf, stdout);
	}
	(void)pclose(fp);
	exit (EXIT_SUCCESS);
}
