module.exports = {
  root: true,
  env: {
    node: true
  },
  'extends': [
    'plugin:vue/essential',
    'eslint:recommended',
    '@vue/typescript/recommended'
  ],
  parserOptions: {
    ecmaVersion: 2020
  },
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    //不需要修改的变量强制使用const
    'prefer-const': 0,
    //禁止空的方法
    '@typescript-eslint/no-empty-function': 0,
    //未使用的变量报错
    '@typescript-eslint/no-unused-vars': 0,
    //禁止使用var
    'no-var': 2,
    //不能比较自身
    'no-self-compare': 1,
    //禁止使用弹窗
    'no-alert': 2,
    //推断禁止使用类型
    '@typescript-eslint/no-inferrable-types': 0,
    //禁止类型与:间有空格
    '@typescript-eslint/type-annotation-spacing': 0,
    //禁止空的代码块
    'no-empty': 0,
    //必须使用全等'==='
    "eqeqeq": 2,
    //强制使用驼峰命名
    "camelcase": 2,
  }
}
