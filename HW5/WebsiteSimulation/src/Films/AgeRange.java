/**
 * this enum attach an age range to a particular age.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Films;

public enum AgeRange {
    A,B,C,D;

    /**
     * this method return proper ageRange according to input age's value.
     * @param age : value of age.
     * @return : proper ageRange according to user's age.
     */
    public static AgeRange getAgeRangeOfAnAge(int age){
        if(0 <= age && age <= 5)
            return A;
        if(10 <= age && age <= 15)
            return B;
        if(16 <= age && age <= 18)
            return C;
        if(age > 18)
            return D;

        return null;
    }

}
