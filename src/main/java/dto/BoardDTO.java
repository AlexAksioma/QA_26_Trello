package dto;

import interfaces.Path;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

@Builder
@Setter
@Getter
@ToString

public class BoardDTO implements Serializable, Path {
    private static final long serialVersionUID = 6547651L;

    private String boardTitle;
    //transient private int boardNumber=123;

    public static void main(String[] args) {
        BoardDTO boardDTO = BoardDTO.builder().boardTitle("ser_new").build();
        serializableBoardDTO(boardDTO, "ser_new3.ser");
        System.out.println(deSerializableBoardDTO("ser_new3.ser"));
    }
    public static void serializableBoardDTO(BoardDTO boardDTO, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SERIALIZE_PATH + fileName));) {
            outputStream.writeObject(boardDTO);
            // outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BoardDTO deSerializableBoardDTO(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SERIALIZE_PATH + fileName))) {
            return (BoardDTO) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
