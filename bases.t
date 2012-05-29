#!/usr/bin/perl

use strict;
use warnings;
use Test::More tests => 16;
#The origins of this perl script was actually my solution to a problem I was given on a job
#application. The problem was given an expression in the form of a + b = c, in which base(s) is
#the addition valid in. The company did not specify a language to do it in, so I chose Perl.
#
#Since then, I've made this test file to do the testing.

sub convert
{	
	#this function will convert a number from some base to base10
	#the idea behind the summation in the for loop is that numbers
	#can be represented in the following way:
	# a*10^n + b*10^(n-1) + c*10^(n-2)... + d*10^1 + e*1 
	# where a,b,c,d,e belong to the set of integers
	
	my $exp = $#_ - 1;		# gives me the higest exponent present in the # a, b, or c
	my $base = $_[$exp + 1];	# $try_base 
	my $sum = 0;
	for (my $i = 0; $i <= $exp; $i++)
	{
		my $e = $exp - $i;
		my $prod = $base ** $e;	# $try_base raised to the e
		$sum = $sum + $_[$i]*$prod;
	}
	return $sum;
}

sub separate{
    #$_[0] is the expression I'm passing to the function
    #the next line removes the spaces & tabs from the expression
    my $exp = $_[0];
    $exp =~ s/\s//g; 
    my @nums = split(/\D+/, $exp);
    if (scalar @nums < 3) {
        return "invalid expression";
    }
    my $a = $nums[0];
    my $b = $nums[1];
    my $c = $nums[2];

    my @digits_a = split(//, $a);	#splits the number into individual digits
    my @digits_b = split(//, $b);
    my @digits_c = split(//, $c);

    #creates a list containing all the digits from the numbers a, b, & c
    my @all_digits = (@digits_a, @digits_b, @digits_c); 

    #finds the largest number in @all_digits so we have some idea which base to start testing at
    #that's so we can save some time in testing for valid bases.
    #for example, if $hi = 4, the smallest base that a number containing 4 is base 5
    my $hi = 0;
    for (my $iter = 0; $iter <= $#all_digits; $iter++) {
        if ($hi < $all_digits[$iter]) {
            $hi = $all_digits[$iter];
        }
    }

    my @valid_bases;
    for(my $try_base = $hi + 1; $try_base <= 10; $try_base++) {
        my $num1 = &convert(@digits_a, $try_base);
        my $num2 = &convert(@digits_b, $try_base);
        my $num3 = &convert(@digits_c, $try_base);

        my $sum12 = $num1 + $num2;
        if ($sum12 == $num3) {
            push(@valid_bases, $try_base);
        }
    }

    my $len = $#valid_bases;
    if ($len >= 0){
        return join(" ", @valid_bases);
    } else {
        return "Not valid in any bases 2-10";
    }
}

is(separate("3  + 7  = 1"), "Not valid in any bases 2-10", "definitely not valid at all");
is(separate("  13 + 4 = 17"), "8 9 10", "should be valid");
is(separate("   1 + 101 = 110"), "2", "testing for base 2");
is(separate("2 + 1 =   10"), "3", "testing base 3");
is(separate("1+3=10"), "4", "testing for base 4");
is(separate("2+ 33 = 40"), "5", "testing for base 5");
is(separate("3+14=21 "), "6", "testing for base 6");
is(separate("25 + 23 = 51"), "7", "testing for base 7");
is(separate("7 + 3 = 12 "), "8", "testing for base 8");
is(separate("72+ 47 = 130"), "9", "testing for base 9");
is(separate("3924 + 362 = 4286"), "10", "testing for base 10");
is(separate("1+1 = 2 "), "3 4 5 6 7 8 9 10", "bases 3-10");
is(separate("57324952 + 4387653 = 61712605"), "10", "really big numbers");
is(separate("42"), "invalid expression", "invalid expression");
is(separate("42 = 42"), "invalid expression", "invalid expression");
is(separate("42 +78234 ="), "invalid expression", "invalid expression");

