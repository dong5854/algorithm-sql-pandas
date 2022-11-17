S = input()

number_sum = 0
letters = []

for i in S:
    if i.isnumeric():
        number_sum += int(i)
    else:
        letters.append(i)

letters.sort()

if number_sum != 0:
    letters.append(str(number_sum))

print(''.join(letters))
