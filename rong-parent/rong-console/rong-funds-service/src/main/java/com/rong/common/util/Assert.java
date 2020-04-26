package com.rong.common.util;

import com.rong.common.consts.CommonEnumContainer;
import com.rong.common.exception.CustomerException;
import com.rong.common.exception.DuplicateDataException;
import com.rong.common.exception.NoExistsException;

import java.util.Collection;
import java.util.Map;

/**
 * creator : whh-lether
 * date    : 2019/6/25 15:25
 * desc    : org.springframework.util
 **/
public abstract class Assert {
    private Assert() {
    }
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void state(boolean expression) {
        state(expression, "[Assertion failed] - this state invariant must be true");
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }


    public static void hasLength(String text, String message) {
        if (StringUtil.isEmpty(text)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }



    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (StringUtil.isNotEmpty(textToSearch) && StringUtil.isNotEmpty(substring) && textToSearch.contains(substring)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring, "[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
    }

    public static void notEmpty(Object[] array, String message) {
        if (CommonUtil.isEmpty(array)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }
    public static void notEmpty(String arg, String message) {
        if (StringUtil.isEmpty(arg)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }
    public static void match(String arg,String regex, String message) {
        if (!arg.matches(regex)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }
    public static void notEmptyThenMatch(String arg,String regex, String message) {
        if (StringUtil.isNotEmpty(arg) && !arg.matches(regex)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void notEmpty(Object[] array) {
        notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            Object[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Object element = var2[var4];
                if (element == null) {
                    throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
                }
            }
        }

    }

    /** @deprecated */
    @Deprecated
    public static void noNullElements(Object[] array) {
        noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (CommonUtil.isEmpty(collection)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map<?, ?> map, String message) {
        if (CommonUtil.isEmpty(map)) {
            throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type, "Type to check against must not be null");
        if (!type.isInstance(obj)) {
            instanceCheckFailed(type, obj, message);
        }

    }

    public static void isInstanceOf(Class<?> type, Object obj) {
        isInstanceOf(type, obj, "");
    }

    public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
        notNull(superType, "Super type to check against must not be null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            assignableCheckFailed(superType, subType, message);
        }

    }

    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }




    public final static void exists(Object o,String message){
        if(CommonUtil.isNull(o)) throw new NoExistsException(message);
    }
    public final static void notExists(Object o,String message){
        if(CommonUtil.isNotNull(o)) throw new DuplicateDataException(message);
    }
    public final static void equal(Integer a,Integer b,String message){
        if(!CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }
    public final static void equal(String a,String b,String message){
        if(!CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }
    public final static void equal(Long a,Long b,String message){
        if(!CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }
    public final static void equal(Enum a,Enum b,String message){
        if(!CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }

    public final static void notEqual(Integer a,Integer b,String message){
        if(CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }
    public final static void notEqual(String a,String b,String message){
        if(CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }
    public final static void notEqual(Long a,Long b,String message){
        if(CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }
    public final static void notEqual(Enum a,Enum b,String message){
        if(CommonUtil.isEqual(a,b)) throw new CustomerException(message, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }











    private static void instanceCheckFailed(Class<?> type, Object obj, String msg) {
        String className = obj != null ? obj.getClass().getName() : "null";
        String result = "";
        boolean defaultMessage = true;
        if (StringUtil.isNotEmpty(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            } else {
                result = messageWithTypeName(msg, className);
                defaultMessage = false;
            }
        }

        if (defaultMessage) {
            result = result + "Object of class [" + className + "] must be an instance of " + type;
        }

        throw new CustomerException(result, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }

    private static void assignableCheckFailed(Class<?> superType, Class<?> subType, String msg) {
        String result = "";
        boolean defaultMessage = true;
        if (StringUtil.isNotEmpty(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            } else {
                result = messageWithTypeName(msg, subType);
                defaultMessage = false;
            }
        }

        if (defaultMessage) {
            result = result + subType + " is not assignable to " + superType;
        }

        throw new CustomerException(result, CommonEnumContainer.ResultStatus.THE_PARAMETERS_DO_NOT_MEET_THE_REQUIREMENTS);
    }

    private static boolean endsWithSeparator(String msg) {
        return msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith(".");
    }

    private static String messageWithTypeName(String msg, Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }




}
