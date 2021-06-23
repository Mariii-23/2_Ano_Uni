#!/bin/bash
echo "
13, 1.0, Álgebra Linear EI
12, 1.0, Cálculo
15, 1.5, Elementos de Engenharia de Sistemas
15, 2.0, Laboratórios de Informática I
14, 1.0, Programação Funcional
17, 1.0, Tópicos de Matemática Discreta

16, 1.0, Análise
17, 2.0, Laboratórios de Informática II
17, 1.0, Lógica EI
10, 1.0, Programação Imperativa
15, 1.0, Sistemas de Computação
12, 1.5, Tópicos de Física Moderna

13, 1.0, Algoritmos e Complexidade
18, 2.0, Arquitetura de Computadores
14, 2.0, Comunicação de Dados
15, 1.5, Engenharia Económica
13, 1.5, Estatística Aplicada
18, 1.0, Introdução aos Sistemas Dinâmicos

15, 2.0, Cálculo de Programas
11, 1.5, Eletromagnetismo EE
20, 2.0, Laboratórios de Informática III
19, 1.0, Opção UMinho
00, 1.0, Programação Orientada aos Objetos
17, 2.0, Sistemas Operativos

00, 2.0, Bases de Dados
00, 2.0, Desenvolvimento de Sistemas de Software
00, 1.5, Métodos Numéricos e Otimização não Linear
00, 1.5, Modelos Determinísticos de Investigação Operacional
00, 2.0, Redes de Computadores
00, 2.0, Sistemas Distribuídos

00, 2.0, Computação Gráfica
00, 2.0, Comunicações por Computador
00, 2.0, Laboratórios de Informática IV
00, 1.5, Modelos Estocásticos de Investigação Operacional
00, 2.0, Processamento de Linguagens
00, 2.0, Sistemas de Representação de Conhecimento e Raciocínio
" | awk -F',' \
    '{ mult += $2; sum += $1 * $2 }
     $1 > 0 { mult0 += $2; sum0 += $1 * $2 }
     END {
         print "Media: " (sum / mult);
         print "Media sem zeros: " (sum0 / mult0)
     }
    '
