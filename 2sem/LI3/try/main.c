/* #include "main.h" */

#include <glib.h>
#include <stdio.h>
#include <stdlib.h>

void example1() {
  GList *list = NULL;
  list = g_list_append(list, "Hello world!");
  printf("The first item is '%s'\n", g_list_first(list)->data);
  g_free(list);
  /* free(list); */
}

/** The following code initializes a GSList, adds two items to it,
 * prints out the list’s length, and frees it: */
void example2() {
  GSList *list = NULL;
  printf("The list is now %d items long\n", g_slist_length(list));
  list = g_slist_append(list, "first");
  list = g_slist_append(list, "second");
  printf("The list is now %d items long\n", g_slist_length(list));
  g_slist_free(list);
}

/** Adding and then remoce data */
/*
** Notes:
** g_slist_remove also returns the new start of the list.
**
*/
void example3() {
  GSList *list = NULL;
  /* Add at the start. O(1) */
  list = g_slist_append(list, "second");
  /* Add at the end. O(N) */
  list = g_slist_prepend(list, "first");
  printf("The list is now %d items long\n", g_slist_length(list));
  list = g_slist_remove(list, "first");
  printf("The list is now %d items long\n", g_slist_length(list));
  g_slist_free(list);
}

/** Removing duplicate itens
 * */
/*
** Note:
** So if a GSList contains the same pointer twice and you call
** g_slist_remove, only the first pointer will be removed. But
** you can remove all occurrences of an item with
** g_slist_remove_all.
*/
void example4() {
  GSList *list = NULL;
  list = g_slist_append(list, "first");
  list = g_slist_append(list, "second");
  list = g_slist_append(list, "second");
  list = g_slist_append(list, "third");
  list = g_slist_append(list, "third");
  printf("The list is now %d items long\n", g_slist_length(list));
  printf("The list have 2 \"second\" ocurences and 2 \"third\" ocurences\n");
  list = g_slist_remove(list, "second");
  list = g_slist_remove_all(list, "third");
  printf("The list is now %d items long\n", g_slist_length(list));
  g_slist_free(list);
}

/**
 *Last, nth, and nth data */
/*
** Note:
** The last printf statement is a bit different. g_slist_next is not a
** function call, but rather a macro. It expands to a pointer derefence
** of the link to the next element in the GSList. In this case, you can
** see that we passed in the first element in the GSList, so the macro
** expanded to provide the second element. It’s a fast operation too, since
** there’s no function call overhead.
*/
void example5() {
  GSList *list = NULL;
  list = g_slist_append(list, "first");
  list = g_slist_append(list, "second");
  list = g_slist_append(list, "third");
  printf("The last item is '%s'\n", g_slist_last(list)->data);
  printf("The item at index '0' is '%s'\n", g_slist_nth(list, 0)->data);
  printf("Now the item at index '0' the easy way: '%s'\n",
         g_slist_nth_data(list, 0));
  printf("And the 'next' item after first item is '%s'\n",
         g_slist_next(list)->data);
  g_slist_free(list);
}

/**
 *Working with a user-defined type */
typedef struct {
  char *name;
  int shoe_size;
} Person;

/*
** Notes:
** 1)
** You can see that putting a user-defined type in a GSList is
** the same as a character string. Note also that you need to
** do a bit of casting when you’re getting the item out of the
** list.
**
** 2)
** This example uses another GLib macro — the g_new macro — to
** create the Fred``Person instance. This macro simply expands
** to use malloc to allocate the correct amount of memory for
** the given type, but it’s a bit cleaner than manually typing
** the malloc function call.
**
** 3)
** Finally, if you’re going to allocate memory, you need to free
** it. You can see how the code sample above uses the GLib function
** g_free to do just that for the Fred``Person instance (since it was
** allocated with g_new ). In most cases g_free just wraps the
** usual free function, but GLib also has memory pooling functionality
** that g_free and other memory-management functions can use.
*/
void example6() {
  GSList *list = NULL;

  Person *tom = (Person *)malloc(sizeof(Person));
  tom->name = "Tom";
  tom->shoe_size = 12;
  list = g_slist_append(list, tom);

  Person *fred = g_new(Person, 1); // allocate memory for one Person struct
  fred->name = "Fred";
  fred->shoe_size = 11;
  list = g_slist_append(list, fred);

  printf("Tom's shoe size is '%d'\n", ((Person *)list->data)->shoe_size);
  printf("The last Person's name is '%s'\n",
         ((Person *)g_slist_last(list)->data)->name);

  g_slist_free(list);
  free(tom);
  g_free(fred);
}

/**
 *
 *Combining, reversing, and all that */
/*
** NOTES:
** Note that the items aren’t copied; they’re just hooked on so that
** the memory needs to be freed only once.
*/
void example7() {
  GSList *list1 = NULL;
  list1 = g_slist_append(list1, "first");
  list1 = g_slist_append(list1, "second");

  GSList *list2 = NULL;
  list2 = g_slist_append(list2, "third");
  list2 = g_slist_append(list2, "fourth");

  GSList *both = g_slist_concat(list1, list2);
  printf("The third item in the concatenated list is '%s'\n",
         g_slist_nth_data(both, 2));

  GSList *reversed = g_slist_reverse(both);
  printf("The first item in the reversed list is '%s'\n", reversed->data);

  g_slist_free(reversed);
}

/**
 *Simple iterating */
void example8() {
  GSList *list = NULL, *iterator = NULL;
  list = g_slist_append(list, "first");
  list = g_slist_append(list, "second");
  list = g_slist_append(list, "third");
  for (iterator = list; iterator; iterator = iterator->next) {
    printf("Current item is '%s'\n", iterator->data);
  }
  g_slist_free(list);
}

/**Simple iterating*/

void print_iterator(gpointer item, gpointer prefix) {
  printf("%s %s\n", prefix, item);
}
void print_iterator_short(gpointer item) { printf("%s\n", item); }

/*
 *Notes:
 *1)
 *The g_strdup function is handy for duplicating a string; just
 *remember to free it once you’re done with it.
 *
 *2)
 *g_slist_foreach lets you pass in a pointer, so you can effectively
 *give it any argument along with each item in the list. For example,
 *you could pass in an accumulator and collect information about each
 *item in a list. The only restriction on the iterating function is
 *that it takes at least one gpointer as an argument; you can see how
 *print_interator_short works even though it accepts only one argument.
 *
 *3)
 *Note that the code frees all the strings using a built in GLib function
 *as an argument to g_slist_foreach. All you had to do in this case was
 *cast the g_free function to a GFunc for this to work. Note that you
 *still have to free the GSList itself with a separate call to g_slist_free.*/
void example9() {
  GSList *list = g_slist_append(NULL, g_strdup("first"));
  list = g_slist_append(list, g_strdup("second"));
  list = g_slist_append(list, g_strdup("third"));
  printf("Iterating with a function:\n");
  g_slist_foreach(list, print_iterator, "-->");
  printf("Iterating with a shorter function:\n");
  g_slist_foreach(list, (GFunc)print_iterator_short, NULL);
  printf("Now freeing each item\n");
  g_slist_foreach(list, (GFunc)g_free, NULL);
  g_slist_free(list);
}

/**
 *Sorting with GCompareFunc */
gint my_comparator(gconstpointer item1, gconstpointer item2) {
  return g_ascii_strcasecmp(item1, item2);
}

/*
** Note:
**
** 1)
** Notice that the GCompareFunc returns a negative value if the first
** item is less than the second, 0 if they’re equal, and a positive
** value if the second is greater than the first. As long as your
** comparison function conforms to this specification, it can do whatever
** it needs to internally.
*/
void example10() {
  GSList *list = g_slist_append(NULL, "Chicago");
  list = g_slist_append(list, "Boston");
  list = g_slist_append(list, "Albany");
  list = g_slist_sort(list, (GCompareFunc)my_comparator);
  printf("The first item is now '%s'\n", list->data);
  printf("The last item is now '%s'\n", g_slist_last(list)->data);
  g_slist_free(list);
}

int main(int argc, char **argv) {
  printf("\tExample 1\n");
  example1();
  printf("\n\tGSList\n");
  example2();
  printf("\n\tAdding and them remove data\n");
  example3();
  printf("\n\tRemoving duplicate itens\n");
  example4();
  printf("\n\tLast, nth,and nth data\n");
  example5();
  printf("\n\tWorking with a user-defined type\n");
  example6();
  printf("\n\tCombining, reversing, and all that\n");
  example7();
  printf("\n\tSimple iterating\n");
  example8();
  printf("\n\tAdvanced iteration with functions\n");
  example9();
  printf("\n\tSorting with GCompareFunc\n");
  example10();
  return 0;
}
