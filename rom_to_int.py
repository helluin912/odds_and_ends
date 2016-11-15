#!/usr/bin/python
s = "CMXCIV" #994
slist = list(s)
alpha = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
val = {'M':1000, 'D':500, 'C':100, 'L':50, 'X':10, 'V':5, 'I':1}

total = val[slist[0]]
for i in range(1, len(slist)):
    if val[slist[i]] > val[slist[i-1]]:
        total = total + val[slist[i]] - (2 * val[slist[i-1]])
    else:
        total += val[slist[i]]

print total
