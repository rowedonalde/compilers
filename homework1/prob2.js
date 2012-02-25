var program = 
{
  'declare': ['x', 'y'],
  'while':
  {
    'condition':
    {
      'minus':
      {
        'left': 'y',
        'right': '5'
      }
    },
    'body':
    {
      'declare': 'y',
      'read': ['x', 'y'],
      'assign':
      {
        'left': 'x',
        'right': 
        {
          'times':
          {
            'left': '2',
            'right':
            {
              'plus':
              {
                'left': '3',
                'right': 'y'
              }
            }
          }
        }
      }
    }
  },
  'write': '5';
}
