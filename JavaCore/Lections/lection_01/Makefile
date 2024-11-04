SRC_DIR := src/main/java
OUT_DIR := out


all:
	javac -sourcepath $(SRC_DIR) -d $(OUT_DIR) src/main/java/org/example/Main.java
clean:
	rm -R $(OUT_DIR)/*
doc:
	javadoc -d docs -sourcepath $(SRC_DIR) -cp $(OUT_DIR) -subpackages org

