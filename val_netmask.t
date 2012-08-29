#!/usr/bin/perl

use strict;
use warnings;

use Test::More tests => 11;
require "val_netmask.pl";

is(check("0.0.0.1"), "false", "definitely does not have a valid netmask");
is(check("255.255.255.252"), "true", "has a valid netmask");
is(check("255.255.192.0"), "true", "has a valid netmask");
is(check("248.0.0.0"), "true", "has a valid netmask");
is(check("255.246.0.0"), "false", "isn't valid");
is(check("255.255.0"), "false", "address too short. not valid");
is(check("255.255.252.0.0"), "false", "address too long. not valid");
is(check("128.0.0.0"), "true", "has valid netmask");
is(check("255.255.0.255"), "false", "there's a zero in the middle");
is(check("0.0.0.0"), "true", "should be recognized /0");
is(check("255.255.255.255"), "true", "the other end of the spectrum");
