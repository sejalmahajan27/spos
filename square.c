#include<jni.h>
#include<stdio.h>
#include "testJni.h" 

JNIEXPORT jint JNICALL Java_testJni_sqr(JNIEnv *e, jobject o, jint a)
{
	jint res;
	res = a * a;
	return res;
}
