#include<jni.h>
#include<stdio.h>
#include "testJni.h" 

JNIEXPORT jint JNICALL Java_testJni_mul(JNIEnv *e, jobject o, jint a,  jint b)
{
	jint res;
	res = a * b;
	return res;
}
