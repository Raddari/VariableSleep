# VariableSleep
Do you hate waiting for everyone to get into bed?
Do you like knowing who just got into bed?
Do you LOVE config files?
Do you hate Phantoms?

In that case, this plugin is for you. Yes, _**you!**_

#### Features
- **Everything listed below is customisable in the config!**
- Only a certain percentage of people required to be in bed to sleep!
- Clears weather upon sleeping
- Disable phantoms (my personal favourite feature)
- Set the time of the world upon waking up
- Message appears when someone gets into a bed, indicating how many more are required to sleep
- Message appears upon successful sleep
- _...And many more to come!_

#### Commands
All commands are prepended with `/variablesleep` or `/vs` followed by a space.
- `reload`
    - _Description:_ Reloads the config file, allowing for changes during server runtime
    - _Aliases:_ None

#### Custom messages
To add colour to the messages, prepend the text with `&` and a certain character.
See [this link](https://minecraft.gamepedia.com/Formatting_codes) for the codes.<br>
**IMPORTANT:** Replace any occurence of the section sign `§` with an ampersand `&`

Certain variables can also be inserted into the message. Currently, these are:
- `[player]` - the name of the player who just got into bed
- `[online]` - number of people online in this world
- `[asleep]` - number of people currently in bed
- `[asleep%]` - percentage of the people online who are in bed
- `[required]` - amount of players required in bed to initiate sleep
- `[required%]` - required percentage of online players in bed to initiate sleep

#### Todo
- [x] Message individual players rather than server-wide broadcast (v1.0.1)
- [ ] Message when someone leaves their bed

Suggestions and bug reports are of course, always welcome!