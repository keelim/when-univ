#include <linux/kernel.h>
#include <linux/init.h>
#include <linux/sched.h>
#include <linux/syscalls.h>

asmlinkage long sys_introduce_my_self(void)
{
	int n=0;
	printk("my id is 201503069 my class is OS02 \n");
	return n;
}

