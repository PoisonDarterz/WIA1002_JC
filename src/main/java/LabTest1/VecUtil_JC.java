package LabTest1;

import java.util.ArrayList;
import java.lang.reflect.*;


// Contains vector operations that work for CPU and GPU numbers
class VecUtil_JC<T> {
    // Vector Constructors
    // TODO (Your Task 2(i & ii) code start here)
    public static <T> ArrayList<T> arr2vec(Class<T> type, int[] arr) {
        ArrayList<T> res = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            try {
                Method method = type.getMethod("fromInteger", Integer.class);
                T obj = (T) method.invoke(type, arr[i]);
                res.add(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
    public static <T> ArrayList<T> ones(Class<T> type, int n) {
        ArrayList<T> res = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            try {
                Method method = type.getMethod("fromInteger", Integer.class);
                T obj = (T) method.invoke(type, 1);
                res.add(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    // Printing Utility
    // TODO (Your Task 2(iii) code start here)
    public static <T> void printVec(ArrayList<T> vec) {
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i).toString() + " ");
        }
        System.out.println();
    }

    // Vector Operations
    public static <T> ArrayList<T> mul(ArrayList<T> a, ArrayList<T> b) {
        ArrayList<T> res = new ArrayList<T>();
        for (int i = 0; i < a.size(); i++) {
            try {
                Method method = a.get(i).getClass().getMethod("mul", a.get(i).getClass());
                T obj = (T) method.invoke(a.get(i), b.get(i));
                res.add(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static <T> ArrayList<T> mul(ArrayList<T> a, T b) {
        ArrayList<T> res = new ArrayList<T>();
        for (int i = 0; i < a.size(); i++) {
            try {
                Method method = a.get(i).getClass().getMethod("mul", a.get(i).getClass());
                T obj = (T) method.invoke(a.get(i), b);
                res.add(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static <T> T dot(ArrayList<T> a, ArrayList<T> b) {
        T res = null;
        for (int i = 0; i < a.size(); i++) {
            try {
                Method method = a.get(i).getClass().getMethod("mul", a.get(i).getClass());
                T obj = (T) method.invoke(a.get(i), b.get(i));
                if (res == null) {
                    res = obj;
                } else {
                    method = res.getClass().getMethod("add", res.getClass());
                    res = (T) method.invoke(res, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
