package by.jwd.task04.entity;

import java.io.Serializable;
import java.util.Objects;

public class CodeBlock implements Serializable {

    private String code;

    public CodeBlock() {
    }

    public CodeBlock(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeBlock)) return false;
        CodeBlock codeBlock = (CodeBlock) o;
        return code.equals(codeBlock.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
