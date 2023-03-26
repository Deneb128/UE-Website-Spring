
# UniversalElements-Website
This is a personal project made to learn the Java Spring framework to handle some functionalities of a MMORPG-style game.
Right now it has a single route to do the registration of an account. Passwords are hashed with BCrypt.


TO DO:
 - [ ] Login route with OAuth2
 - [ ] Connection to the other databases: public_player and public_stats
 - Account management:
	  - [ ] Password change
	  - [ ] E-mail change
	  - [ ] PC authorization (enable another computer to log with the account in game)
    - [ ] Characters List
 - [ ] Players ranking
    - [ ] Character info page
 - [ ] Guilds ranking
     - [ ] Guild info page
 - [ ] Ranked Seasons data
 - [ ] Game statistics (damage/kills/deaths/assists/crowd controls for: guild wars/dungeons/raids/world bosses)
 - CCC:
	  - [ ] Ban and unban of accounts and or players (with automatic disconnection of the player in game)
	  - [ ] Logging of data events in game (such as gold generated)
      - [ ] Multiple findBys based on type of quests completed, or classes chosen etc.
	  - [ ] Management of in game event flags
