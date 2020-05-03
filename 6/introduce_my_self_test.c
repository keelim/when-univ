#include <stdio.h>
#include <unistd.h>
#include <linux/kernel.h>
#include <sys/syscall.h>

int introduce_my_self(void)
{
	return syscall(548);
}

void main()
{
	int n = introduce_my_self();
	printf("introduce_my_self() : return is %d\n", n);
}
