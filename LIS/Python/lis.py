def buildTable(initial) -> list:
    matrix = [[1 for x in range(len(initial))] for y in range(2)]

    for x in range(len(initial)):
        matrix[1][x] = 0
    
    for i in range(len(initial)):
        for j in range(0, i):
            if initial[i] > initial[j]:
                if matrix[0][i] <= matrix[0][j]:
                    matrix[0][i] = matrix[0][j] + 1
                    matrix[1][i] = j

    return matrix       

def rebuiltTable(initial, array, index, lista) -> list:
    if index != 0:
        lista.append(initial[index])
        rebuiltTable(initial, array, array[index], lista)
    else:
        if initial[index] < initial[index+1]:
            lista.append(initial[index])
                

    return lista
            
        
        

def printMatrix(matrix):
    for x in range(len(matrix) - 1, -1, -1):
        print(matrix[x], end = ' ')
    print()


#initial = (0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15)
#initial = (1, 3, 2, 7, 8)
initial = (14, 2, 4, 2, 7, 0, 13, 21, 20)
matrix = buildTable(initial)
lista = rebuiltTable(initial, matrix[1], len(initial)-1, [])
printMatrix(lista)
