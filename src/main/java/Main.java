import java.io.*;
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        long SUPER_SIZE = Integer.MAX_VALUE;
        OffHeapArray array = new OffHeapArray(SUPER_SIZE);
        byte[] classBytes = new byte[0];
        User user = new User();
        user.setName("Andreyd");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(user);
            user = null;
            out.flush();
            classBytes = bos.toByteArray();

            for (int i = 0;i < classBytes.length;i++) {
                array.set((long) Integer.MAX_VALUE + i, classBytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] classBytesNew = new byte[999999999];
        for (int i = 0;i < classBytes.length;i++){
            classBytesNew[i] += array.get((long) Integer.MAX_VALUE + i);
        }
        classBytes = null;

        ByteArrayInputStream bis = new ByteArrayInputStream(classBytesNew);
        try (ObjectInput in = new ObjectInputStream(bis)) {
            Object o = in.readObject();
            User users = (User) o;
            System.out.println(users.getName());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
