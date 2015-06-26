#!/usr/bin/perl

#use strict;
use DBI;
use Net::Telnet;
use Socket;

my $DB_NAME = "zeh";
my $DB_HOST = "10.10.10.11";
my $DB_USER = "kpj";
my $DB_PASSWD = "znh1sge";

$blind_bed2 = "stop";
$blind_living2 = "stop";
$blind_bath2 = "stop";
$blind_entrance2 = "stop";


while(1){
	 $dbh = DBI->connect("dbi:Pg:dbname=$DB_NAME;host=$DB_HOST", $DB_USER, $DB_PASSWD)
			or die "$!\n Error: failed to connect to DB.\n";

	 $sth = $dbh->prepare("SELECT light_mode, blind_living, blind_bed, blind_bath, blind_entrance, radiator_mode, fan_mode, air1_status, air1_mode, air1_temp, air1_wind, air2_mode, air2_status, air2_temp, air2_wind  FROM control");
	$sth->execute;

		while ($ary_ref = $sth->fetchrow_arrayref) {
			  ($light_mode, $blind_living, $blind_bed, $blind_bath, $blind_entrance, $radiator_mode, $fan_mode, $air1_status, $air1_mode, $air1_temp, $air1_wind, $air2_mode, $air2_status, $air2_temp, $air2_wind) = @$ary_ref;
			print "light_mode: $light_mode \n";
				if ($light_mode2 ne $light_mode) {
					&light_mode;
				}
					$light_mode2 = $light_mode;
#			print "blind_living2: $blind_living2 \n";

			print "blind_living: $blind_living \n";
				if ($blind_living2 ne $blind_living) {
					&blind_living;
				}
					$blind_living2 = $blind_living;
#			print "blind_living2: $blind_living2 \n";

			print "blind_bed: $blind_bed \n";
				if ($blind_bed2 ne $blind_bed) {
					&blind_bed;
				}
					$blind_bed2 = $blind_bed;
#			print "blind_bed2: $blind_bed2 \n";

			print "blind_bath: $blind_bath \n";
				if ($blind_bath2 ne $blind_bath) {
					&blind_bath;
				}
					$blind_bath2 = $blind_bath;
#			print "blind_bath2: $blind_bath2 \n";

			print "blind_entrance: $blind_entrance \n";
				if ($blind_entrance2 ne $blind_entrance) {
					&blind_entrance;
				}
					$blind_entrance2 = $blind_entrance;
#			print "blind_entrance2: $blind_entrance2 \n";

			print "radiator_mode: $radiator_mode \n";
			print "fan_mode: $fan_mode \n";
			print "living_air_status: $air1_status \n";
			print "living_air_mode: $air1_mode \n";
			print "living_air_temp: $air1_temp \n";
			print "living_air_wind: $air1_wind \n";
			print "bedroom_air_status: $air2_status \n";
			print "bedroom_air_mode: $air2_mode \n";
			print "bedroom_air_temp: $air2_temp \n";
			print "bedroom_air_wind: $air2_wind \n";
			
exec "java -classpath /home/kpj/echonet/core.jar:/home/kpj/echonet/ecj.jar:/home/kpj/echonet/indivisual_set_ac 0 mode Heating";
		}

	$dbh->disconnect;

	sleep(3);
}


############################################################################################
sub blind_living{
	

#Client
#make socket
my $sock;
socket ($sock, PF_INET, SOCK_STREAM, getprotobyname('tcp'))
	or die "Cannot create socket: $!";

$ipAddress ='192.168.1.50';

#make socket information
#host
my $remote_host = $ipAddress;
my $packed_remote_host = inet_aton($remote_host)
	or die "Cannot pack $remote_host: $!";

#port number
#my $remote_port = 51013;
my $remote_port = 23;

#packing host and port number
my $sock_addr = sockaddr_in($remote_port, $packed_remote_host)
	or die "Cannot pack $remote_host:$remote_port: $!";

#connect
connect($sock, $sock_addr)
	or die "Cannot connect $remote_host:$remote_port:$!";

print "Connected!\n";

#write data
my $old_handle = select $sock;
$| = 1;
select $old_handle;

#make a code 0x51
#my $message = &subpackage::TimeGet;
#my $message = "*au\\r\\n";

if ($blind_living eq "off"){
	print $blind_living;
	my $message = "c";

	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}

if ($blind_living eq "stop"){
	print $blind_living;
	my $message = "s";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

if ($blind_living eq "up"){
	print $blind_living;
	my $message = "o";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

#finish writing
shutdown $sock, 1;
sleep(2);
#read data
while (my $line = <$sock>){
	print "$line\n";
}
sleep(2);
#close socket
close $sock;
}

##############################################################################
sub blind_bed{
	

#Client
#make socket
my $sock;
socket ($sock, PF_INET, SOCK_STREAM, getprotobyname('tcp'))
	or die "Cannot create socket: $!";

$ipAddress ='192.168.1.51';

#make socket information
#host
my $remote_host = $ipAddress;
my $packed_remote_host = inet_aton($remote_host)
	or die "Cannot pack $remote_host: $!";

#port number
#my $remote_port = 51013;
my $remote_port = 23;

#packing host and port number
my $sock_addr = sockaddr_in($remote_port, $packed_remote_host)
	or die "Cannot pack $remote_host:$remote_port: $!";

#connect
connect($sock, $sock_addr)
	or die "Cannot connect $remote_host:$remote_port:$!";

print "Connected!\n";

#write data
my $old_handle = select $sock;
$| = 1;
select $old_handle;

#make a code 0x51
#my $message = &subpackage::TimeGet;
#my $message = "*au\\r\\n";

if ($blind_bed eq "down"){
	print $blind_bed;
	my $message = "c";

	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}

if ($blind_bed eq "stop"){
	print $blind_bed;
	my $message = "s";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

if ($blind_bed eq "up"){
	print $blind_bed;
	my $message = "o";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

#finish writing
shutdown $sock, 1;
sleep(2);
#read data
while (my $line = <$sock>){
	print "$line\n";
}
sleep(2);
#close socket
close $sock;
}


#######################################################################################
sub blind_bath{
	

#Client
#make socket
my $sock;
socket ($sock, PF_INET, SOCK_STREAM, getprotobyname('tcp'))
	or die "Cannot create socket: $!";

$ipAddress ='192.168.1.53';

#make socket information
#host
my $remote_host = $ipAddress;
my $packed_remote_host = inet_aton($remote_host)
	or die "Cannot pack $remote_host: $!";

#port number
#my $remote_port = 51013;
my $remote_port = 23;

#packing host and port number
my $sock_addr = sockaddr_in($remote_port, $packed_remote_host)
	or die "Cannot pack $remote_host:$remote_port: $!";

#connect
connect($sock, $sock_addr)
	or die "Cannot connect $remote_host:$remote_port:$!";

print "Connected!\n";

#write data
my $old_handle = select $sock;
$| = 1;
select $old_handle;

#make a code 0x51
#my $message = &subpackage::TimeGet;
#my $message = "*au\\r\\n";

if ($blind_bath eq "down"){
	print $blind_bath;
	my $message = "c";

	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}

if ($blind_bath eq "stop"){
	print $blind_bath;
	my $message = "s";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

if ($blind_bath eq "up"){
	print $blind_bath;
	my $message = "o";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

#finish writing
shutdown $sock, 1;
sleep(2);
#read data
while (my $line = <$sock>){
	print "$line\n";
}
sleep(2);
#close socket
close $sock;
}



#######################################################################################
sub blind_entrance{
	

#Client
#make socket
my $sock;
socket ($sock, PF_INET, SOCK_STREAM, getprotobyname('tcp'))
	or die "Cannot create socket: $!";

$ipAddress ='192.168.1.54';

#make socket information
#host
my $remote_host = $ipAddress;
my $packed_remote_host = inet_aton($remote_host)
	or die "Cannot pack $remote_host: $!";

#port number
#my $remote_port = 51013;
my $remote_port = 23;

#packing host and port number
my $sock_addr = sockaddr_in($remote_port, $packed_remote_host)
	or die "Cannot pack $remote_host:$remote_port: $!";

#connect
connect($sock, $sock_addr)
	or die "Cannot connect $remote_host:$remote_port:$!";

print "Connected!\n";

#write data
my $old_handle = select $sock;
$| = 1;
select $old_handle;

#make a code 0x51
#my $message = &subpackage::TimeGet;
#my $message = "*au\\r\\n";

if ($blind_entrance eq "down"){
	print $blind_entrance;
	my $message = "c";

	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}

if ($blind_entrance eq "stop"){
	print $blind_entrance;
	my $message = "s";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

if ($blind_entrance eq "up"){
	print $blind_entrance;
	my $message = "o";

	print $sock $message;
	print $sock "\n";
	print "send: $message";
}

#finish writing
shutdown $sock, 1;
sleep(2);
#read data
while (my $line = <$sock>){
	print "$line\n";
}
sleep(2);
#close socket
close $sock;
}


#######################################################################################
sub light_mode{
	

#Client
#make socket
my $sock;
socket ($sock, PF_INET, SOCK_STREAM, getprotobyname('tcp'))
	or die "Cannot create socket: $!";

$ipAddress ='192.168.1.60';

#make socket information
#host
my $remote_host = $ipAddress;
my $packed_remote_host = inet_aton($remote_host)
	or die "Cannot pack $remote_host: $!";

#port number
my $remote_port = 51013;

#packing host and port number
my $sock_addr = sockaddr_in($remote_port, $packed_remote_host)
	or die "Cannot pack $remote_host:$remote_port: $!";

#connect
connect($sock, $sock_addr)
	or die "Cannot connect $remote_host:$remote_port:$!";

print "Connected!\n";

#write data
my $old_handle = select $sock;
$| = 1;
select $old_handle;

#make a code 0x51
#my $message = &subpackage::TimeGet;
#my $message = "*au\\r\\n";

if ($light_mode eq "1"){

	my $message = "*is;350\r\n";
	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}


if ($light_mode eq "2"){

	my $message = "*is;360\r\n";
	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}


if ($light_mode eq "3"){

	my $message = "*is;351\r\n";
	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}


if ($light_mode eq "4"){

	my $message = "*is;361\r\n";
	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}


if ($light_mode eq "0"){

	my $message = "*is;363\r\n";
	print $sock $message;
	print $sock "\n";
	print "send: $message\n";
}

#finish writing
shutdown $sock, 1;
sleep(2);
#read data
while (my $line = <$sock>){
	print "$line\n";
}
sleep(2);
#close socket
close $sock;
}

