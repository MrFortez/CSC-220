

def c7(boxWidth, personHeight):
 # figure out message
 if (personHeight <= 3.0):
 message = 'You are a child'
 elif (3.3 < personHeight <= 4.5):
 message = 'Still growing'
 elif (4.7 < personHeight <= 5.3):
 message = 'Short adult'
 elif (5.5 < personHeight <= 10.0):
 message = 'Normal height adult'
 else:
 message = 'Unknown'

 # calculate how to center message
 padding = max(0, boxWidth - (len(message) + 4))
 textBefore = ' ' * (padding // 2)
 textAfter = ' ' * ((padding + 1) // 2)

 # construct and return output
 result = '*' * boxWidth + '\n'
 result += '* ' + textBefore + message + textAfter + ' *\n'
 result += '*' * boxWidth + '\n'
 return result