/* #include "guiao.h" */

int ex() {

  /* isto nao funciona */

  int p[2];
  pipe(p); // sempre antes do fork

  if (!fork) {
    // redir stdin
    close(p[1], dup2(p[0], 0));
    close(p[0]);

    execlp("wc", "wc", "-l", NULL);
    perror();
    exit();
  } else {

    close(p[0], dup2(p[1], 1));
    close(p[1]);
    execlp("lc", "lc", "/etc", NULL);
  }
  return 0;
}
