def printMove(fr, to):
    print('move from' + str(fr) + ' to ' + str(to))

def Towers(n, fr, to, aux):
    if n == 1:
        printMove(fr, to)
    else:
        Towers(n-1, fr, aux, to)
        Towers(1, fr, to, aux)
        Towers(n-1, aux, to, fr)