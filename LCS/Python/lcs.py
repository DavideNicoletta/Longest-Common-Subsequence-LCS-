def printTable(table) -> None:
    for row in table:
        for element in row:
            print(element, end = ' ')
        print()

def buildTable(firstVector, secondVector) -> list:
    m = int(len(firstVector))
    n = int(len(secondVector))
    table = [[0 for x in range(n + 1)] for y in range(m + 1)]
    for i in range(m + 1):
        for j in range(n + 1):
            if (i == 0 and j == 0) or (i == 0 and j != 0) or (i != 0 and j == 0):
                table[i][j] = 0
            elif firstVector[i - 1] == secondVector[j - 1]:
                table[i][j] = table[i-1][j-1] + 1
            elif table[i][j - 1] > table[i - 1][j]:
                table[i][j] = table[i][j - 1]
            else:
                table[i][j] = table[i - 1][j]
    printTable(table)
    return table



def rebuiltTable(table, m, n, firstVector, secondVector, LCS) -> str:
    if m == 0 and n == 0:
        return ""
    else:
        if table[m][n] == table[m - 1][n] and table[m][n] == table[m][n - 1]:
            if firstVector[m - 1] == secondVector[n - 1]: 
                    LCS = firstVector[m - 1] + rebuiltTable(table, m - 1, n - 1, firstVector, secondVector, LCS)
            else:
                    LCS = rebuiltTable(table, m - 1, n, firstVector, secondVector, LCS)
        else:
            if firstVector[m - 1] == secondVector[n - 1]:
                        LCS = firstVector[m - 1] + rebuiltTable(table, m - 1, n - 1, firstVector, secondVector, LCS)
            else:
                if table[m - 1][n] >= table[m][n - 1]:
                    LCS = rebuiltTable(table, m - 1, n, firstVector, secondVector, LCS)
                else:
                    LCS = rebuiltTable(table, m, n - 1, firstVector, secondVector, LCS)

    return LCS     



def reverse(LCS) -> str:
    LCSList = list(LCS)
    string = ""
    max = len(LCSList) - 1
    for x in range(max, -1, -1):
        string = string + LCSList[x]
    
    return string
    



string1 = input("Inserisci stringa 1\n")
string2 = input("Inserisci stringa 2\n")

firstVector = list(string1)
secondVector = list(string2)



print("LCS: " + reverse(
        rebuiltTable(
            buildTable(firstVector, secondVector), len(firstVector), len(secondVector), firstVector, secondVector, "")))

