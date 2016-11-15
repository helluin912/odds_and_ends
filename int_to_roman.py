#!/usr/bin/python

roman = ['M', 'D', 'C', 'L', 'X', 'V','I']
#        -7         -5        -3       -1
#         0         2          4       6
print "integer = 3859"
num = list(str(3859))

#output = list()

#for i in range(-1, -len(num) - 1, -1): #works backwards
#	temp = ''
#	if int(num[i]) <= 3:
#		for n in range(int(num[i])):
#			temp.append(roman[i])
#		output

base = -1
out = ""
for i in range(len(num)-1, -1, -1):
	temp = ''
	if int(num[i]) <= 3:
		for n in range(int(num[i])):
			temp += roman[base]
	elif int(num[i]) == 4:
		temp = roman[base] + roman[base - 1]
	elif int(num[i]) == 5:
		temp = roman[base-1]
	elif int(num[i]) == 9:
		temp = roman[base] + roman[base-2]
	else: #6,7,8
		diff = int(num[i]) - 5
		temp = roman[base-1]
		for n in range(diff):
			temp += roman[base]

#	output.append(temp)
	out = temp + out
	base -= 2

#print output
print "roman numeral: " + out
