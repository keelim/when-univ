typedef enum { FALSE, TRUE } Boolean; // c boolean 지원 X enum 을 통한 타입 정의
#define MAXFLOAT (float)3.4E+38   //캐스팅이 없을 경우 double이기에 (float) 캐스팅
#define EPSILON (float) 1.0E-6   // 0.000001 을 EPSILON 으로 대체
#define FloatValueIsZero(NUMBER) (fabsf(NUMBER) < EPSILON)  //함수를 대체 할 수 있는 기능 NUMBER `parameter` 지원
