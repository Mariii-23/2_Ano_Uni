#include "../includes/Squad.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
  SQUAD squad = initSquad();
  squad = loadSquadFromFile(squad, "input_files/players.txt");
  printf("Squad Size = %d \n", getSquadSize(squad));
  printf("Striker count: %d\n", getTotalStrikers(squad));
  char *strikerLine = strdup("Cristiano Ronaldo:7:Avancado");
  PLAYER player = initPlayerFromFileLine(strikerLine, ":");
  addPlayerToSquad(squad, player);
  printf("Striker count after adding Ronaldo: %d\n", getTotalStrikers(squad));
  StrArray strikers = getStrikers(squad);
  for (int i = 0; i < getLength(strikers); ++i) {
    printf("Striker: %s\n", getStrElement(strikers, i));
  }

  /* for (int i = 0; i < getTotalStrikers(squad); ++i) { */
  /*   printf("Striker: %s\n", getPlayerInfo(getStrElement(squad, i))); */
  /* } */

  destroyStrArray(strikers);
  destroySquad(squad);
  free(strikerLine);
  destroyPlayer(player);
  return 0;
}
