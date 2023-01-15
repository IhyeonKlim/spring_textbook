package com.JYSHS.AfterSchool.aggregate;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public abstract class Entity {
//abstract로 만들어서 모든 Class는 이것을 상속하도록 만들어야 한다. String id.
    //lombok 이용 -> 게터세터. for) 객체 무셜성 보장. ex) 몸무게 -1000kg 입력 방지, 노출할 데이터의 선별.

    /** Note
     *
     * 추상화 : abstract
     * 추상 : 사물을 정확하게 이해하기 위해 사물이 지니고 있는 여러 가지 측면 가운데서 특정한 측면만을 가려내어 포착하는 것.
     *
     * 객체지향에서 가장 중요한 것 2가지를 꼽는다면 다음과 같다.
     *   1. 추상화
     *   2. 상속
     *
     * 추상화란 알고는 있지만 표현하기 애매한 것을 중요한 부분이나 특징점을 잡아 설명한다는 것이다.
     * 객체지향에서 추상화란 '클래스를 정의할 때 불필요한 부분은 생략하고 중요한 것에만 중점을 두어 개략화하는 것.'
     * 즉, 모든 클래스들의 공통적인 특징을 잡는 것이다.
     *       객체지향의 추상화는 다음 2가지 종류가 있다.
     *       1. 객체와 관련된 속성만 표시하는 데이터 추상화.
     *           for) 상속하기 위해서. 상속 : 하위 개념이 상위 개념의 모든 것을 물려받음.
     *           ex) 아이폰
     *           아이폰 > 카메라 어플 기능
     *           휴대폰 > 카메라 기능
     *           통신기기 > 통화 기능
     *           전자제품 : 전원기능
     *
     *           ***) 공통기능은 상위 요소에서 미리 구현한다.
     *
     *       2. 불필요하고 세부적인 정보는 숨기는 제어 추상화.
     *           for) 생산성, 가독성, 에러감소, 유지보수의 용이성을 위해서.
     *           ex) 우리는 차를 운전하는데 있어서 엔진의 동작원리까지 알 필요는 없다.
     *           ***) 추상적으로 메서드 동작을 가늠해 결과값만 받고 끝낸다.
     * */



    protected String id; //UUID를 통해 생성되는 고유값

    /** Note2
     *
     *  protected. 같은 패키지(클래스) 안에서 상속접근.
     *
     * cf. public - 누구든 다씀
     *     protected - 우리 식구(같은 패키지) + 내 자식(상속) 씀
     *     default - 우리 식구(같은 패키지)만 씀
     *     private - 나만씀 (상속 안시킴)
     *
     *  접근 허용 가능 범위
     *  public > protected > default > private
     *
     *  이걸 왜 나누냐? 의도치 않은 변수 값의 변경을 막기 위해 + 접근의 보안성 때문.
     */

    protected Date regDate; //작성일

    //생성자.
    protected Entity(){
        this.id = UUID.randomUUID().toString();
        this.regDate = new Date();
        //고유한 값을 만드기 위해 사용하는 UUID 유틸. 여기에서 생성.
    }

    //id를 받는 경우 그냥 그걸 쓰겠다.
    protected Entity(String id){
        this.id = id;
    }
}