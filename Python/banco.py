user = "joao"
agencia = "1"
conta = "12"

saques = 0
saldo = 0
SAQUES_DIARIOS = 3
LIM_DIARIO = 500

def deposito():
    global saldo
    valor = int(input("Digite o valor que deseja depositar:"))
    saldo += valor
    print(f"O valor disponível na conta é de {saldo}")

def saque():
    global saldo
    global saques
    global LIM_DIARIO
    global SAQUES_DIARIOS

    valor = int(input("Quanto você deseja sacar?"))

    if SAQUES_DIARIOS == 0:
        print("Você já utilizou seus 3 saques diários")

    if valor > LIM_DIARIO:
        print("O valor digitado excede o valor limitado por dia.")

    if saldo == 0:
        print("Você nao possui saldo em conta.")

    elif saldo >= valor:
            print("Sacando...")
            
            saldo -= valor
            SAQUES_DIARIOS -= 1
            saques += 1

            print(f"O valor agora na conta é de: {saldo}")

            

def extrato(user, agencia, conta):
    global saldo
    global saques
    global SAQUES_DIARIOS

    extrato_f = f"""
    ---------Banco do João------------
    Olá {user}, {agencia}, {conta}, aqui está seu extrato do dia:

    Saldo disponível: {saldo}
    Você realizou: {saques} saques.
    Você ainda tem {SAQUES_DIARIOS} que podem ser realizados.

    Qualquer dúvida estou à disposição para 0000-0000.

    Obrigado!
    """
    return extrato_f

menu = """
[d] Depositar
[s] Sacar
[e] Extrato
[q] Sair

===> """


while True:
    op = input(menu)
    if op == "d":
        print("Depósito:")
        deposito()
    
    elif op == "s":
        if saldo > 0:
            print("Saque:")
            saque()
        else:
            print("Você não possui saldo em conta. Faça um depósito para poder proceguir com o saque.")

    elif op == "e":
        print("Extrato")
        print(extrato(user, agencia, conta))

    elif op == "q":
        print("Saindo")
        break
    else:
        print("Operação inválida, por favor selecione novamente a operação desejada.")  