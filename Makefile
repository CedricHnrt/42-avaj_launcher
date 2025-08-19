# COLOR
_GREEN = \033[92m
_YELLOW = \033[33m
_RED = \033[31m

# POLICE
_END = \033[0m
_BOLD = \033[1m

NAME = avaj_launcher

# JAVA
JAVAC = @javac
JAVA  = @java
JFLAGS = -g -Xlint:all

# DIRS
SRC_DIR = src
BIN_DIR = bin

# OUTILS
RM = @rm -rf
MKDIR = @mkdir -p
PRINT = @echo

# Classe principale (modifiable à l'appel : make run MAIN=com.foo.Bar)
MAIN ?= com.avaj.launcher.Main

# Sources Java (récursif)
SOURCES := $(shell find $(SRC_DIR) -name "*.java")

# Scenario pour la simulation
SCENARIO ?= scenario.txt

# ============================================================

all: $(BIN_DIR)/.compiled

$(BIN_DIR)/.compiled: $(SOURCES)
	$(MKDIR) $(BIN_DIR)
	$(PRINT) "\n${_YELLOW}Compiling Java sources...${_END}"
	$(JAVAC) $(JFLAGS) -d $(BIN_DIR) -sourcepath $(SRC_DIR) $(SOURCES)
	@touch $@
	$(PRINT) "${_BOLD}${_GREEN}Build OK.\a${_END}"

run: all
	$(PRINT) "${_YELLOW}Running $(MAIN)${_END}\n"
	$(JAVA) -cp $(BIN_DIR) $(MAIN) $(SCENARIO)

jar: all
	$(PRINT) "${_YELLOW}Packaging JAR $(NAME).jar...${_END}"
	@echo "Main-Class: $(MAIN)" > $(BIN_DIR)/MANIFEST.MF
	@(cd $(BIN_DIR) && jar cfm $(NAME).jar MANIFEST.MF .)
	$(PRINT) "${_BOLD}${_GREEN}JAR created at $(BIN_DIR)/$(NAME).jar\a${_END}"

clean:
	$(PRINT) "\n${_RED}Cleaning class files...${_END}"
	@find $(BIN_DIR) -name "*.class" -delete || true
	@$(RM) $(BIN_DIR)/.compiled $(BIN_DIR)/MANIFEST.MF
	$(PRINT) "${_GREEN}Classes cleaned.${_END}"

fclean:
	$(PRINT) "${_RED}Deleting $(BIN_DIR)...${_END}"
	$(RM) $(BIN_DIR)
	$(PRINT) "${_GREEN}Deleted.${_END}"

re: fclean all

.PHONY: all clean fclean re run jar
