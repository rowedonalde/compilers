#manatee_tokens.py
#Takes Manatee Source as input and outputs the program's token sequence

import fileinput
import re

#The list of tokens in this manatee program
tokens = []

#This pattern matches either a
#string literal, a word char sequence, a newline
#and any of the operators:
token_pattern = r'[\r\n]|(".*(?<!\\)"|\w+\b|[+*/:=;[\]{}<>.,!]|(?<!-)-(?!-))'
token_matcher = re.compile(token_pattern)

#This pattern matches comments:
comment_pattern = r'--[^\r\n]*'
comment_matcher = re.compile(comment_pattern)

#Takes a string of Manatee terminated by at most one newline and returns a list
#with the first token in that string at index 0 and the rest of the
#string at index 1:
def first_token(string):
    global token_matcher
    #Get the leftmost token in this string:
    match = token_matcher.search(string)
    if match:
        token = match.group()
    
        #index beginning the rest of the string:
        if len(string) == match.end():
            rest_of_string = None
        else:
            rest_of_string = string[match.end():]

        return [token, rest_of_string]
    else:
        return [None, None]
    

#loop through the lines of the file passed through stdin:
for line in fileinput.input():

    #The current remainder of this line during processing:
    current = comment_matcher.sub(" ", line) #Replace comments with spaces

    #Keep pulling tokens off the beginning of this string until there are none left:
    while current:
        result = first_token(current)
        #Put the new token in the list:
        if result[0]: #To make sure a string indeed had another token and not just space/comment
            tokens.append(result[0])
            
        #The remainder of the string after that token:
        current = result[1]

#After the tokens have been sequenced, print them out:
for t in tokens:
    if t in "\r\n":
        print "BR"
    else:
        print t
        
