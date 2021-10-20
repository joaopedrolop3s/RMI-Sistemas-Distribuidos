COM242 - SISTEMAS DISTRIBUIDOS
RMI

AMBIENTE:

O ambiente é composto por 2 máquinas linux virtualizadas através de containers do docker. A imagem do ubuntu usada pode ser verifficada no arquivo "dockerfile" na raiz do projeto.

O arquivo "docker-compose" é responsável por criar os 2 containers. Eles fazer parte de uma rede e simulam a conexão externa. Isso pode ser verificado pelo comando telnet:

 - Ao usar telnet e o ip da maquina obtem-se erro de conexão.

 - Ao usar telnet com ip da maquina e a porta 1099 a conexão obtém sucesso.

para obter o ip da maquina usar:
 - docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' rmi-server

Ao definir colocar dois containers em uma mesma rede, é possível usar tanto o ip como nome do container para apontar um membro na rede. Isto pode ser verificado com:

 - ping 27.0.20.1 (este ip muda)
ou
 - ping rmi-server (este nome é sempre o mesmo)

O fato de o nome do container nunca mudar, foi escolhido para definir a uri de conexão do RMI.


[rmi-server] <-------network--------> [rmi-client]
[----------------imagem ubuntu-------------------]

--------------------------------------------------------------------------------------------------

INSTRUÇÕES PARA EXECUÇÃO

Todas operações precisam ser feitas dentro dos containers usando "docker exec".

1) Certifique se a conexão entre as máquinas cliente e servidor está livre. Para isso, teste o ping sobre as duas perspectivas (ping cliente para servidor e depois servidor para cliente).

2) No arquivo do código cliente (Cliente.java), atualize o endereço IP para o do servidor atual.

3) Faça a compilação do programa tanto no Cliente como no Servidor através do comando:
javac *.java

4) Comando para criação dos stubs. Após a execução do comando será criado o arquivo (ServidorMat_Stub.class)
rmic ServidorMat

5) Inicie o Servidor:
java ArrancaServidor

6) Inicie o Cliente:
java Cliente



