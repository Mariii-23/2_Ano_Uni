# Exemplo de um módulo de dados SQUAD, que armazena dados do tipo PLAYER.  

Este programa (prog.c) exemplifica o funcionamento de um módulo de dados simples que armazena jogadores lidos do ficheiro "Jogadores.txt", usando estruturas de dados da glib. Para cada linha deste ficheiro é criada a entidade PLAYER, um módulo que abstrai esta representação de jogador, definindo-o como um tipo de dados (opaco).

O módulo de dados SQUAD incorpora uma GTREE da glib de PLAYERs, uma árvore binária balanceada. A sua implementação e respetiva API respeita o encapsulamento, permitindo inserir, consultar/devolver informação que não compromete a sua segurança, retornando cópias de conteúdo usando tipos genéricos. Para devolver listas de strings (ver função getStrikers()), usa o array genérico GArray, que neste exemplo em concreto foi formatado especialmente para usar strings, conforme definido  no módulo auxiliar AuxStructs. Este GArray poderá obviamente ser reutilizado para outros tipos de dados. O modulo AuxStructs foi criado apenas para tornar a implementação de uma lista de strings independente desse tipo GArray e formatado especialmente para trabalhar com esse tipo de dados. 

Este exemplo demonstra também como podem verificar se o vosso programa tem "memory leaks". Isto é, se estão a gerir a memória dinâmica corretamente, fazendo free de toda a memória alocada na Heap. Esta verificação pode ser feita usando a ferramenta valgrind, que consegue identificar estas "fugas" de memória. O output esperado para um programa corretamente implementado deve ser semelhante ao ilustrado na figura valgrind_out.png .

# Instalação
Para correrem o programa nas vossas máquinas, terão que instalar a glib e o pkg-config.

MAC OS (usando homebrew):
	brew install glib
	brew install pkg-config

Linux (usando apt):
	sudo apt install libgtk2.0-dev
	sudo apt install pkg-config






