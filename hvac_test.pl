#!/usr/bin/perl 

$test = Heating;

#exec "java -classpath /home/kpj/echonet/core.jar:/home/kpj/echonet/ecj.jar:/home/kpj/echonet indivisual_set_ac 8 status ON";
exec "java -classpath /home/kpj/echonet/core.jar:/home/kpj/echonet/ecj.jar:/home/kpj/echonet indivisual_set_ac 8 mode $test";

