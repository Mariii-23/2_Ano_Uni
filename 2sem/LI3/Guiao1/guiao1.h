#ifndef __GUIAO1_H_
#define __GUIAO1_H_

#define PATH_review "reviews.csv"
#define PATH_business "business.csv"
#define PATH_users "users.csv"

#define MAX_BUFFER 1024

void print_file(char *name_in, int fd_out);

char **to_buffer(char *name);

typedef struct user {
  char user_id[MAX_BUFFER];
} USER;

typedef struct review {
  char review_id[MAX_BUFFER];
  char user_id[MAX_BUFFER];
  char business_id[MAX_BUFFER];
  double stars;
  int useful;
  int funny;
  int cool;
} REVIEW;

typedef struct CSVReview {
  REVIEW *self;
  struct CSVReview *next;
} CSVREVIEW;

typedef struct bussines {
  char business_id[MAX_BUFFER];
  char name[MAX_BUFFER];
  char city[MAX_BUFFER];
  double stars;
  int review_count;
} BUSSINES;

#endif // __GUIAO1_H_
