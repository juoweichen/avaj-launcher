NAME = avajlaunch
MAIN_CLASS = AvajLaunch

JC = javac
JAVA = java
JFLAGS = -d .

SRC_DIR = srcs
SRCS = $(wildcard $(SRC_DIR)/*.java)

.PHONY: all clean fclean re qre

all: $(NAME)

$(NAME):
	@$(JC) $(JFLAGS) $(SRCS)
	@echo "\033[32mJava compiled\033[0m"
run:
	@$(JAVA) $(NAME).$(MAIN_CLASS)

clean:
	@rm -rf $(NAME)
	@echo "\033[31mPackage clean\033[0m"

re: clean all