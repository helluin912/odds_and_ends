#/usr/bin/perl
use warnings;
use strict;
#inspired by https://en.wikipedia.org/wiki/IPv4_subnetting_reference
sub check{
	my @separate = split(/\./, $_[0]);

	#no point in continuing if the address isn't the correct length!
	if ($#separate != 3){
		print "not a valid address!\n";
		return "false";
	}
	for (my $i = 0; $i <= $#separate; $i++){
		$separate[$i] = sprintf("%08b", $separate[$i]);
		#%08b = can contain leading 0s, 8 digits long, and in binary
	}
	my $binary = join("", @separate);
	my @valid = split(/0/, $binary);
	
	#cannot have a 0 in the middle of the binary string for a valid netmask
	if ($#valid < 1) {
		print "$_[0] is a valid net mask\n";
		my @temp = split(//, $valid[0]);
		my $len = $#temp + 1;
		print "slash (aka CIDR) notation would be /$len\n";
		return "true";
	}
	else{
		print "$_[0] is NOT a valid net mask\n";
		return "false";
	}
}

my $address = "255.255.252.0";
&check($address);
