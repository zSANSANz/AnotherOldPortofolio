<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'wp_media_pembelajaran');

/** MySQL database username */
define('DB_USER', 'root');

/** MySQL database password */
define('DB_PASSWORD', '');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8mb4');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'Z]f$Zj}}goPYU9i#ROt)5Sh/XNS[anac14*(P9N0aY$[tXKOz}/{49XhW=aco n;');
define('SECURE_AUTH_KEY',  'c V%Brzi+CGe9~k9=,{M@!LZTM(B.T5RYl_^?mw[fFgO4:_EKTbtI!aU#r1f8.b3');
define('LOGGED_IN_KEY',    '&GPW,Q>^!QsC8Q10;D4~_7aFi,:93~%7|GA2M^{vp`d1IgF<4>;^v(re]+JnGuV}');
define('NONCE_KEY',        '!N,@|-avVj<jsB]jYEUrchkBan`<-1Ve-Lh*BBc#,6&9ekOy3TC&H<3c91nM|1H/');
define('AUTH_SALT',        'yb=DAuFH*q&Sr*[&2Lj^(.{%:sbE+EC,FZa!$1sWC69{ cw/??-^Zv%&BF}T(-re');
define('SECURE_AUTH_SALT', 'Bt{GZP.!$aH+#AzD|pW:tf&m*=v<)1?6gOUay]r}TAXxie0-(S=${qmxk|~h0LaW');
define('LOGGED_IN_SALT',   'jC}D|RSs=%lH!mpFi0~/E4^5A4i|a}lF.={&Z4!yEzh<EiKq<%|:fFwo!(KqTq)1');
define('NONCE_SALT',       'PbQe9&y><1v/a=-h0Lt^T=/|x3S{?hZxo0{Bt)DJR/#[@Dg,MKmY@@SjBk6i$Y/u');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
